<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ReservationCours
 *
 * @ORM\Table(name="reservation_cours", indexes={@ORM\Index(name="id_client", columns={"id_client"}), @ORM\Index(name="id_cours", columns={"id_cours"})})
 * @ORM\Entity
 */
class ReservationCours
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_reservationCours", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idReservationcours;

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
     * Get idReservationcours
     *
     * @return integer
     */
    public function getIdReservationcours()
    {
        return $this->idReservationcours;
    }

    /**
     * Set idCours
     *
     * @param \AppBundle\Entity\Cours $idCours
     *
     * @return ReservationCours
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
     * @return ReservationCours
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
