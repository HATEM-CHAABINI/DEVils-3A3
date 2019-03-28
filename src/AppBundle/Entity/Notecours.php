<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Notecours
 *
 * @ORM\Table(name="notecours", indexes={@ORM\Index(name="id_client", columns={"id_client"}), @ORM\Index(name="id_cours", columns={"id_cours"})})
 * @ORM\Entity
 */
class Notecours
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var integer
     *
     * @ORM\Column(name="note", type="integer", nullable=false)
     */
    private $note;

    /**
     * @var \Cours
     *
     * @ORM\ManyToOne(targetEntity="Cours")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_cours", referencedColumnName="id_cours")
     * })
     */
    private $idCours;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_client", referencedColumnName="id")
     * })
     */
    private $idClient;



    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set note
     *
     * @param integer $note
     *
     * @return Notecours
     */
    public function setNote($note)
    {
        $this->note = $note;

        return $this;
    }

    /**
     * Get note
     *
     * @return integer
     */
    public function getNote()
    {
        return $this->note;
    }

    /**
     * Set idCours
     *
     * @param \AppBundle\Entity\Cours $idCours
     *
     * @return Notecours
     */
    public function setIdCours(\AppBundle\Entity\Cours $idCours = null)
    {
        $this->idCours = $idCours;

        return $this;
    }

    /**
     * Get idCours
     *
     * @return \AppBundle\Entity\Cours
     */
    public function getIdCours()
    {
        return $this->idCours;
    }

    /**
     * Set idClient
     *
     * @param \AppBundle\Entity\FosUser $idClient
     *
     * @return Notecours
     */
    public function setIdClient(\AppBundle\Entity\FosUser $idClient = null)
    {
        $this->idClient = $idClient;

        return $this;
    }

    /**
     * Get idClient
     *
     * @return \AppBundle\Entity\FosUser
     */
    public function getIdClient()
    {
        return $this->idClient;
    }
}
