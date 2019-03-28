<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Rating
 *
 * @ORM\Table(name="rating", indexes={@ORM\Index(name="fk_rating", columns={"id"}), @ORM\Index(name="fk_rating_event", columns={"idEvent"})})
 * @ORM\Entity
 */
class Rating
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idRating", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idrating;

    /**
     * @var integer
     *
     * @ORM\Column(name="rate", type="integer", nullable=false)
     */
    private $rate;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id", referencedColumnName="id")
     * })
     */
    private $id;

    /**
     * @var \Evenement
     *
     * @ORM\ManyToOne(targetEntity="Evenement")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idEvent", referencedColumnName="idEvent")
     * })
     */
    private $idevent;



    /**
     * Get idrating
     *
     * @return integer
     */
    public function getIdrating()
    {
        return $this->idrating;
    }

    /**
     * Set rate
     *
     * @param integer $rate
     *
     * @return Rating
     */
    public function setRate($rate)
    {
        $this->rate = $rate;

        return $this;
    }

    /**
     * Get rate
     *
     * @return integer
     */
    public function getRate()
    {
        return $this->rate;
    }

    /**
     * Set id
     *
     * @param \AppBundle\Entity\FosUser $id
     *
     * @return Rating
     */
    public function setId(\AppBundle\Entity\FosUser $id = null)
    {
        $this->id = $id;

        return $this;
    }

    /**
     * Get id
     *
     * @return \AppBundle\Entity\FosUser
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set idevent
     *
     * @param \AppBundle\Entity\Evenement $idevent
     *
     * @return Rating
     */
    public function setIdevent(\AppBundle\Entity\Evenement $idevent = null)
    {
        $this->idevent = $idevent;

        return $this;
    }

    /**
     * Get idevent
     *
     * @return \AppBundle\Entity\Evenement
     */
    public function getIdevent()
    {
        return $this->idevent;
    }
}
